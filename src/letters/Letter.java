package letters;

import city.Inhabitant;
import content.Content;

/**
 * 
 *
 * @param <T>
 *            : Type of letter content
 */
public abstract class Letter<T extends Content> implements Content {

	protected Inhabitant sender;
	protected Inhabitant receiver;
	protected T content;

	public Letter(Inhabitant sender, Inhabitant receiver, T content) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
	}

	public Inhabitant getSender() {
		return sender;
	}

	public Inhabitant getReceiver() {
		return receiver;
	}

	public T getContent() {
		return content;
	}

	/**
	 * This method is triggered when an inhabitant receives the letter.
	 */
	public abstract void action();

	public abstract int cost();

	public abstract String description();
}