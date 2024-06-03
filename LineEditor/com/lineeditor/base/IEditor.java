package com.lineeditor.base;

import java.io.IOException;

public interface IEditor {

	void list();

	void delete(int lineNumber);

	void insert(int lineNumber, String lineContent);

	void save() throws IOException;

	void quit();

}
