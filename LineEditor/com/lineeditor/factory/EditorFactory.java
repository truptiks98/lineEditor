package com.lineeditor.factory;

import java.io.IOException;

import com.lineeditor.base.IEditor;
import com.lineeditor.text.TextEditor;

public class EditorFactory {
	
	 public IEditor getEditor(String type, String args) throws IOException {
		switch(type) {
		case "txt":return new TextEditor(args);
		}
		return null;
	}

}
