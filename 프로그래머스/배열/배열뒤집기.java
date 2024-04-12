class 배열뒤집기 {

    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        int j = 0;

        for (int i = num_list.length - 1; i >= 0; i--) {
            answer[j] = num_list[i];
            j++;
        }
        return answer;
    }

    /*
     * List<Integer> list = Arrays.stream(numList).boxed().toList();
     * -> toList()는 16버전부터 지원 -> .collect(Collectors.toList());
     * 
     * Collections.reverse(list);
     * return list.stream().mapToInt(Integer::intValue).toArray();
     */

}