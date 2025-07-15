package com.gla;
import java.util.*;
abstract class Notification{
	String message;
	Notification(String message){
		this.message=message;
	}
	abstract void display();
}
  class LikeNotification extends Notification{

	LikeNotification(String message) {
		super(message);
	}

	@Override
	void display() {
		System.out.println("Like: "+message);
	}
 }
  class CommentNotification extends Notification{

		CommentNotification(String message) {
			super(message);
		}

		@Override
		void display() {
			System.out.println("comment: "+message);
		}
	 }
class Feed{
	private LinkedList<Notification>list=new LinkedList<>();
	public void addNotification(Notification notification) {
		list.addFirst(notification);
	}
	public void display() {
		for(Notification notification:list) {
			notification.display();
		}
		
	}
}
public class SocialMediaNotificationFeed {
	public static void main(String[] args) {
		Feed feed=new Feed();
		feed.addNotification(new LikeNotification("Anurag liked your post"));
		feed.addNotification(new CommentNotification("Looking good"));
		feed.display();
	}
}
