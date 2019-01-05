package kasei.javase.designpattern.structure.adapter;

public class PlayerMP3 {
	MediaAdapter adapter;
	
	public void playMP3(String type) {
		if(type.equalsIgnoreCase("mp3")){
			System.out.println("MP3 播放器");
		}else if(type.equalsIgnoreCase("mp4")){
			adapter = new MediaAdapter();
			adapter.play();
		}		
	}
}
