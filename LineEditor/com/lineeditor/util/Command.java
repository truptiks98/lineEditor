package com.lineeditor.util;

public enum Command {
	DISPLAY("disp"),
	LIST("list"),
	DELETE("del"),
	INSERT("ins"),
	QUIT("quit"),
	SAVE("save");
	
	private String value;
	Command(String value) {
		 this.value=value;
	}

	public static Command fromValue(String value) {
        for (Command command : Command.values()) {
            if (command.getValue().equals(value)) {
                return command;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
	
	public String getValue() {
		return this.value;
	}

}
