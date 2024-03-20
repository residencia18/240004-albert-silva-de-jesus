package com.swproject.sellgenius.entities.enums;

public enum PerfilTipo {

	ADMIN(1, "ADMIN"), FUNCIONARIO(2, "FUNCIONARIO");

	private long cod;
	private String desc;

	private PerfilTipo(long cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public long getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

	public static PerfilTipo valueOf(int code) {
		for (PerfilTipo value : PerfilTipo.values()) {
			if (value.getCod() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid PerfilTipo code");
	}

}
