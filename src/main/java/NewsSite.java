
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NTLAHLA W
 */

import java.util.ArrayList;
import java.util.List;

public class NewsSite implements Subject {
  private List<Observer> observers;
	private String message;
	private boolean changed;
        private String site;
	private final Object MUTEX= new Object();
	
	public NewsSite(String st){
                this.site = st;
		this.observers=new ArrayList<>();
	}
	@Override
	public void register(Observer obj) {
		if(obj == null) throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
		if(!observers.contains(obj)) observers.add(obj);
		}
	}

	@Override
	public void unregister(Observer obj) {
		synchronized (MUTEX) {
		observers.remove(obj);
		}
	}

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
		//synchronization is used to make sure any observer registered after message is received is not notified
		synchronized (MUTEX) {
			if (!changed)
				return;
			observersLocal = new ArrayList<>(this.observers);
			this.changed=false;
		}
		for (Observer obj : observersLocal) {
			obj.update();
		}

	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}
	
	//method to post message to the topic
	public void publishLatestNewsHeadline(String msg){
                System.out.println(" ");
		System.out.println("Latest News HeadLine Published by eNCA:"+msg);
		this.message=msg;
		this.changed=true;
		notifyObservers();
	}   
}
