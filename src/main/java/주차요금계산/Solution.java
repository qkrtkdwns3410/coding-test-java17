package 주차요금계산;

import java.util.*;

/**
 * main, PRINT_RESULT 는 테스트 케이스 실행 및 결과 확인을 위한 함수입니다.
 * [답안지 복사] 기능을 사용하는 경우 해당 함수들을 제외하며, 답안에 필요한 코드만 복사됩니다.
 * 테스트 케이스 추가 등 함수 내부 변경은 가능하나, 함수 이름 변경시 [답안지 복사] 기능이 제대로 동작하지 않습니다.
 *
 * 또한, 기본 설정으로 [답안지 복사] 사용시 해당 주석과 작성하신 주석을 제외하여 복사됩니다.
 * [주석 복사] 여부는 설정을 통해 변경할 수 있습니다.
 *
 * [도움말 주석] 옵션은 설정을 통해 제거할 수 있습니다.
 *
 * - [답안지 복사]
 *   코드 - 답안지 복사 (기본 단축키 cmd + shift + w)
 *
 * - [도움말 주석]
 *   설정 - 도구 - 프로그래머스 헬퍼 - 도움말 주석
 *
 * - [주석 복사]
 *   설정 - 도구 - 프로그래머스 헬퍼 - 주석 복사
 *
 * GitHub: https://github.com/moseoh/programmers_helper
 */
class Solution {
    public static void main(String[] args) {

    }
    
    public static void PRINT_RESULT(int index, int[] result, int[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }
    
    public List<Integer> solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> enteredAt = new HashMap<>();
        Map<String, Integer> totalMinutes = new TreeMap<>();
        
        final Fee fee = Fee.from(fees);
        
        for (String record : records) {
            System.out.println("record = " + record);
            
            final String[] s = record.split(" ");
            final String[] times = s[0].split(":");
            
            final Integer hoursToMinutes = Integer.parseInt(times[0]) * 60;
            final Integer minutes = Integer.parseInt(times[1]);
            
            final Integer sumMinutes = hoursToMinutes + minutes;
            
            final String regNumber = s[1];
            final String option = s[2];
            
            if (Objects.equals("IN", option)) {
                //입차
                enteredAt.put(regNumber, sumMinutes);
            } else {
                //출차
                final int cumurateMinutes = totalMinutes.getOrDefault(regNumber, 0);
                totalMinutes.remove(regNumber);
                totalMinutes.put(regNumber, cumurateMinutes + sumMinutes);
                System.out.println("totalMinutes = " + totalMinutes);
                enteredAt.remove(regNumber);
            }
            
            System.out.println("enteredAt = " + enteredAt);
            
            for (Map.Entry<String, Integer> entry : enteredAt.entrySet()) {
                totalMinutes.put(entry.getKey(), 1439 - entry.getValue());
            }
        }
        
        return answer;
    }
    
    record Fee(int baseTime, int baseFee, int unitTime, int unitFee) {
        Fee() {
            this(180, 5000, 10, 600);
        }
        
        static Fee from(int[] fees) {
            return new Fee(fees[0], fees[1], fees[2], fees[3]);
        }
    }
}
