package study6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExample5 {
	public static void main(String[] args) {
        Path path = Paths.get("study\\커밋메세지 저장txt.txt"); // 실제 파일 경로로 변경하세요
        
        try {
            // 파일에서 모든 라인을 읽고, 단어 단위로 분리하여 빈도수 계산
            Map<String, Long> wordFrequency = Files.lines(path)
                .flatMap(line -> Arrays.stream(line.toLowerCase().split("\\W+")))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
                ));
            
            // 빈도수가 높은 상위 10개 단어 추출
            List<Map.Entry<String, Long>> topWords = wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toList());
            
            System.out.println("가장 많이 등장한 단어:");
            topWords.forEach(entry -> 
                System.out.println(entry.getKey() + ": " + entry.getValue() + "회")
            );
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}