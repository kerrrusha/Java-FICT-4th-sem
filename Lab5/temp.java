public class train {
    public static void main(String[] args) 
    {
        int[] list = new int[100];
        // 0 1 2 3 4 5 6 7 8 9
        for(int i = 0; i < list.length; i++)
            list[i] = (int)(100 * Math.random());
        for(int i = 0; i < list.length; i++)
            System.out.print(Integer.toString(list[i]) + ' ');

        //найти все простые числа
        for(int i = 0; i < list.length; i++)
        {
            boolean is_single = true;
            for(int j = 2; j <= list[i] / 2; j++)
            {
                //если берем число 11: 2 3 4 5
                //если берем число 15: 2 3
                if((list[i] / (double)(j)) - (int)(list[i] / (double)(j)) == 0)
                {
                    is_single = false;
                    break;
                }
            }
            if(is_single == true)
                System.out.println(list[i]);
        }
    }
}