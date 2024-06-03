package com.lineeditor;

import java.io.IOException;
import java.util.Scanner;

import com.lineeditor.util.Command;
import com.lineeditor.base.IEditor;
import com.lineeditor.factory.EditorFactory;

public class LineEditorApp {
	public static void main(String[] args) {
		if (args.length != 2 || !"lineeditor".equalsIgnoreCase(args[0])) {
			System.out.println("Usage: lineeditor <file path>");
			return;
		}

		try {
			EditorFactory editFactory=new EditorFactory();
			IEditor editor = editFactory.getEditor(args[1].split("\\.")[1], args[1]);
			try (Scanner scanner = new Scanner(System.in)) {
				com.lineeditor.util.Command command;
				String nextCommand;

				while (true) {
					System.out.print(">> ");
					nextCommand = scanner.nextLine();
					if (!nextCommand.isEmpty()) {
						String[] tokens = nextCommand.split(" ");
						try {
							command = Command.fromValue(tokens.length >= 1 ? tokens[0] : "");
							switch (command) {
							case LIST:
								editor.list();
								break;
							case SAVE:
								editor.save();
								break;
							case QUIT:
								editor.quit();
								break;
							case DELETE:
								if (tokens.length == 2) {
									int lineNumber = Integer.parseInt(tokens[1]);
									editor.delete(lineNumber);
								} else {
									System.out.println("Invalid command format");
								}
								break;
							case INSERT:
								if (tokens.length == 3) {
									int lineNumber = Integer.parseInt(tokens[1]);
									String lineContent = tokens[2].trim();
									editor.insert(lineNumber, lineContent);
								} else {
									System.out.println("Invalid command format");
								}
								break;
							default:
								break;
							}
						} catch (IllegalArgumentException e) {
							System.out.println("Command not found :" + tokens[0]);
						}
					}
				}

			}
		} catch (IOException e) {
		}
	}
}
