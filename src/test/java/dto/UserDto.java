package dto;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.response.Response;

public class UserDto {
	private String id;
	private String nomeFirst;
	private String nomeLast;
	private String email;
	private String avatar;

	public UserDto() {
		this.setValid();
	}

	public UserDto(Response response, UserDto oldUser) {
		try {
			this.id = response.jsonPath().getString("data.id");
			this.nomeFirst = response.jsonPath().getString("data.first_name");
			this.nomeLast = response.jsonPath().getString("data.last_name");
			this.email = response.jsonPath().getString("data.email");
			this.avatar = response.jsonPath().getString("data.avatar");
		} catch (Exception e) {
			this.id = oldUser.getId();
			this.nomeFirst = oldUser.getNomeFirst();
			this.nomeLast = oldUser.getNomeLast();
			this.email = oldUser.getEmail();
			this.avatar = oldUser.getAvatar();
		}
	}

	public UserDto(String id, String nomeFirst, String nomeLast, String email, String avatar) {
		this.id = id;
		this.nomeFirst = nomeFirst;
		this.nomeLast = nomeLast;
		this.email = email;
		this.avatar = avatar;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeFirst() {
		return nomeFirst;
	}

	public void setNomeFirst(String nomeFirst) {
		this.nomeFirst = nomeFirst;
	}

	public String getNomeLast() {
		return nomeLast;
	}

	public void setNomeLast(String nomeLast) {
		this.nomeLast = nomeLast;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public void setValid() {
		this.setId("2");
		this.setNomeFirst("Janet");
		this.setNomeLast("Weaver");
		this.setEmail("janet.weaver@reqres.in");
		this.setAvatar("https://reqres.in/img/faces/2-image.jpg");
	}

	public String getJson() {
		Map<String, String> data = new HashMap<String, String>();
		data.put("id", this.id);
		data.put("first_name", this.nomeFirst);
		data.put("last_name", this.nomeLast);
		data.put("email", this.email);
		data.put("avatar", this.avatar);
		JSONObject jsonData = new JSONObject(data);
		String json = jsonData.toJSONString();
		return json;
	}

	public String getJson(boolean withoutCPF) {
		Map<String, String> data = new HashMap<String, String>();
		if (withoutCPF == true) {
			data.put("id", this.id);
		}
		data.put("first_name", this.nomeFirst);
		data.put("last_name", this.nomeLast);
		data.put("email", this.email);
		data.put("avatar", this.avatar);
		JSONObject jsonData = new JSONObject(data);
		String json = jsonData.toJSONString();
		return json;
	}
}
