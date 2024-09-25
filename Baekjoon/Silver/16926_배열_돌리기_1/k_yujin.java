import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 배열 입력 받기
        int [][] array = new int[N+2][M+2];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dx[] = {0,1,0,-1};
        int dy[] = {1,0,-1,0};

        // R번만큼 돌리기
        for(int r=0; r<R; r++){
            int row = N;
            int col = M;
            int direction = 0;
            int startIndex = 1;

            // 한 번 회전 - 바깥 영역 부터 안쪽 영역으로 이동
            while(row >=2 && col>=2){
                int count= 0;
                int start = startIndex++;
                int x = start;
                int y = start;
                int preValue = array[start][start];

                // 시작 위치로 다시 돌아올 때까지 반복
                do{
                    x = x + dx[direction];
                    y = y + dy[direction];

                    int temp = array[y][x];
                    array[y][x] = preValue; // 전진한 좌표 갱신
                    preValue = temp;

                    count++;

                    // 세로 방향일 때
                    if(direction == 0 || direction == 2){
                        if(count == row-1){
                            direction= (direction+1)%4;
                            count =0;
                        }

                        // 가로 방향일 때
                    } else{
                        if(count == col-1){
                            direction= (direction+1)%4;
                            count =0;
                        }
                    }
                    // 처음 위치로 돌아오기 전까지 이동
                }while(x!= start || y!= start);

                row -= 2;
                col -= 2;
            }
        }

        //출력
        for(int i=1; i<=N; i++){
            for(int j = 1;j<=M; j++){
                bw.write(array[i][j] +" ");

            }
            bw.write("\n");
        }


        bw.flush();

        bw.close();
        br.close();
    }


}

