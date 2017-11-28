public class Test {
	public static void main(String[] args) {

		SeparateChainingHashTable<String,Integer> st = new SeparateChainingHashTable<String,Integer>(1000000);

		st.put("北京",new Integer(1));
		st.put("上海",new Integer(2));
		st.put("天津",new Integer(3));
		st.put("重庆",new Integer(4));
		st.put("广东",new Integer(5));
		st.put("福建",new Integer(6));
		st.put("西藏",new Integer(7));

		System.out.println(st.get("北京"));
		System.out.println(st.get("上海"));
		System.out.println(st.get("天津"));
		System.out.println(st.get("重庆"));
		System.out.println(st.get("广东"));
		System.out.println(st.get("福建"));
		System.out.println(st.get("西藏"));

		st.remove("广东");

		System.out.println(st.get("北京"));
		System.out.println(st.get("上海"));
		System.out.println(st.get("天津"));
		System.out.println(st.get("重庆"));
		System.out.println(st.get("广东"));
		System.out.println(st.get("福建"));
		System.out.println(st.get("西藏"));

		System.out.println(st.contains("广东"));
		System.out.println(st.contains("北京"));
	}
}