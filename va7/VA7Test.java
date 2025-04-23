package programmierung2.va7;

import java.util.Map;

import studiplayer.basic.BasicPlayer;
import studiplayer.basic.TagReader;

public class VA7Test {

	public static void main(String[] args) {
		Map<String, Object> tagMap = TagReader.readTags("audiofiles/Rock 812.mp3");
		for (String tag : tagMap.keySet()) {
			Object value = tagMap.get(tag);
			System.out.printf("key: %-25s value: %-30s (type: %s)\n",
				tag, value, value.getClass().getSimpleName());

		}

		String s = "%02d:%02d".formatted(3, 5);
		System.out.println(s);
		BasicPlayer.play("audiofiles/Rock 812.mp3");
	}

}
