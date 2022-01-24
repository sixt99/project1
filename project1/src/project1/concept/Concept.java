package project1.concept;

public class Concept {
	public String nativeWord;
	public String translation;

	public String getNativeWord() {
		return nativeWord;
	}

	public String getTranslation() {
		return translation;
	}

	public void setNativeWord(String nativeWord) {
		this.nativeWord = nativeWord;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	@Override
	public String toString() {
		return String.format("%s: %s", nativeWord, translation);
	}

}
