import java.util.*;

/**
 * @ program: 20200713
 * @ Description：
 * @ CreateTime：2020/7/13 14:41
 * @ Author：Mr Zhang
 */


public class TestDemo {
/*  开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
    处理:
    1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
    2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
    3.输入的文件可能带路径，记录文件名称不能带路径
*/
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        while(sc.hasNext()) {
            //开始输入
            String path = sc.next();
            int id = path.lastIndexOf("\\");
            String filename = id == -1 ? path : path.substring(id + 1);
            int line = sc.nextInt();
            //统计次数
            String key = filename + " " + line;
            if(map.containsKey(key)) {
                map.put(key,map.get(key) + 1);
            }else {
                map.put(key,1);
            }
        }

        //排序
        List<Map.Entry<String,Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        //保存前8条记录
        int m = 0;
        for(Map.Entry<String,Integer> mapping : list) {
            if(m >= 8) {
                break;
            }

            String[] str = mapping.getKey().split(" ");
            String filename = str[0];
            if(filename.length() > 16) {
                filename = filename.substring(filename.length() - 16);
            }
            String n = str[1];
            Integer count = mapping.getValue();
            System.out.printf("%s %s %d%n",filename, n, count);
            m++;
        }
    }

    //输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
    //都按先录入排列在前的规则处理。
    static class Student {
        String name;
        int score;
        int number;

        public Student(String name, int score, int number) {
            this.name = name;
            this.score = score;
            this.number = number;
        }
    }

    // 传入两个 student，请告诉我谁应该靠前
    static class AscComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            /*
            if (o1.score != o2.score) {
                return o1.score - o2.score;
            } else {
                return o1.number - o1.number;
            }
            */

            if (o1.score < o2.score) {
                return -1;  // 只要是负数，就代表 o1 靠前
            } else if (o1.score > o2.score) {
                return 1;   // 返回整数，就代表 o2 靠前
            } else {
                // 代表成绩相同
                if (o1.number < o2.number) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }

    static class DescComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.score != o2.score) {
                return o2.score - o1.score;
            } else {
                return o1.number - o2.number;
            }
        }
    }

    public static void main2(String[] args) {
        // 1. 处理输入
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//排序的人的个数
        int a = scanner.nextInt();//排序方法0（降序）或者1（升序）
        boolean ascOrDesc = true;   // true 代表升序；false 代表降序
        if (a == 0) {
            ascOrDesc = false;
        }
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int score = scanner.nextInt();
            students[i] = new Student(name, score, i);
        }

        // 因为我要调用的排序方法是 Arrays.sort
        if (ascOrDesc) {
            Arrays.sort(students, new AscComparator());
        } else {
            Arrays.sort(students, new DescComparator());
        }

        // 3. 处理输出
        for (int i = 0; i < n; i++) {
            System.out.println(students[i].name + " " + students[i].score);
        }
    }

}
