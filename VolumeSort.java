import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.Arrays;

public class VolumeSort{
	public static void main(String[] args) {
		int[] nums1 = {4,5,6,5,4,3};
		int[] nums2 = {8,5,5,5,5,1,1,1,4,4};		
		System.out.println(Arrays.toString(productSort(nums1)));
		System.out.println(Arrays.toString(productSort(nums2)));
	}
	
	public static int[] volumeSort(int[] nums){
		//make ret array
		int[] retArray = new int[nums.length];
		//make a hashmap
		HashMap<Integer, Integer> numMap = new HashMap<>();
		for(int num : nums){
			numMap.put(num, numMap.getOrDefault(num, 0) + 1);
		}
		//now have a map with keys as nums and values as number of times in nums[]

		//make a minHeap that checks if have the same value, then return smaller one
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : a.getValue() - b.getValue());

		minHeap.addAll(numMap.entrySet());

		int index = 0;
		while(!minHeap.isEmpty()){
			Map.Entry<Integer, Integer> entry = minHeap.poll();
			for(int i = 0; i < entry.getValue(); i++){
				retArray[index++] = entry.getKey();
			}
		}
		return retArray;
	}
}
