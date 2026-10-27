package programmers.택배배달과수거하기;

class Solution {
    // cap: 트럭 적재 한도, n: 집 개수
    // deliveries[i], pickups[i]: i + 1번째 집의 배달 및 수거 상자 수
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        // TODO: 모든 배달과 수거를 마치고 창고로 돌아오는 최소 이동 거리 계산
        int deliveryIndex = deliveries.length - 1;
        int pickupIndex = pickups.length - 1;
        long answer = 0;
        
        while (deliveryIndex >= 0 || pickupIndex >= 0) {
            while (deliveryIndex >= 0 && deliveries[deliveryIndex] == 0) {
                deliveryIndex--;
            }
            
            while (pickupIndex >= 0 && pickups[pickupIndex] == 0) {
                pickupIndex--;
            }
            
            if (deliveryIndex < 0 && pickupIndex < 0) {
                break;
            }
            
            answer += (Math.max(deliveryIndex, pickupIndex) + 1) * 2L;
            
            int remainingCap = cap;
            //배달 가장 먼집부터
            while (deliveryIndex >= 0 && remainingCap > 0) {
                int count = Math.min(deliveries[deliveryIndex], remainingCap);
                deliveries[deliveryIndex] -= count;
                remainingCap -= count;
                
                if (deliveries[deliveryIndex] == 0) {
                    deliveryIndex--;
                }
            }
            
            remainingCap = cap;
            //픽업 가장 먼집부터
            while (pickupIndex >= 0 && remainingCap > 0) {
                int count = Math.min(pickups[pickupIndex], remainingCap);
                pickups[pickupIndex] -= count;
                remainingCap -= count;
                
                if (pickups[pickupIndex] == 0) {
                    pickupIndex--;
                }
            }
        }
        
        return answer;
    }
}
