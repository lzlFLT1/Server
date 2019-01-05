package kasei.javase.designpattern.structure.adapter;

//适配器模式：在一个类A中组合适配器类B，使其能调用其他类C的模式
public class MediaAdapter {

	PlayerMP4 mp4Player;
	
	public MediaAdapter(){
		mp4Player = new PlayerMP4();
	}

	public void play() {
		mp4Player.playMP4();
	}
}
