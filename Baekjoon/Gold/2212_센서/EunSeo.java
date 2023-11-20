import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class Main {

    public static int[] sensor; // 센서들의 좌표
    public static int[] distance; // 센서들 사이의 거리
    public static int result = 0; // 결과

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 센서의 개수
        int k = Integer.parseInt(br.readLine()); // 집중국의 개수

        sensor = new int[n];
        distance = new int[n-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<sensor.length; i++){
            int position = Integer.parseInt(st.nextToken());
            sensor[i] = position;
        }
        Arrays.sort(sensor);

        for(int i = 0; i<distance.length; i++){
            distance[i] = sensor[i+1] - sensor[i];
        }

        Arrays.sort(distance);

        for(int i = 0; i<n-k; i++){
            result += distance[i];
        }
        System.out.println(result);
    }
}