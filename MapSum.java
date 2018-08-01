package leetcode.test.chaijb;

public class MapSum {
	private String[] strArr;
	private int[] intArr;
    /** Initialize your data structure here. */
    public MapSum() {
        strArr = new String[20];
        intArr = new int[20];
    }
    
    public void insert(String key, int val) {
    	boolean flag = false;
        for (int i = 0; i < strArr.length; i++) {
			if (key.equals(strArr[i])) {
				intArr[i] = val;
				flag = true;
				break;
			}
		}
        if (!flag) {
			for (int i = 0; i < strArr.length; i++) {
				if (strArr[i] == null || "".equals(strArr[i])) {
					strArr[i] = key;
					intArr[i] = val;
					break;
				}
			}
		}
    }
    
    public int sum(String prefix) {
    	int result = 0;
    	for (int i = 0; i < strArr.length; i++) {
			if (strArr[i] != null && strArr[i].startsWith(prefix)) {
				result += intArr[i];
			}
		}
		return result;
    }
	

	/**
	 * Your MapSum object will be instantiated and called as such:
	 * MapSum obj = new MapSum();
	 * obj.insert(key,val);
	 * int param_2 = obj.sum(prefix);
	 */
    public static void main(String[] args) {
		MapSum obj = new MapSum();
		obj.insert("apple", 3);
		System.out.println(obj.sum("app"));
		
		obj.insert("app", 1);
		System.out.println(obj.sum("ap"));
		
		obj.insert("app", 2);
		System.out.println(obj.sum("ap"));
	}
	/**
	 * ["MapSum", "insert", "sum", "insert", "sum"] 
	 * [[], ["apple",3], ["ap"],["app",2], ["ap"]]
	 */
}
