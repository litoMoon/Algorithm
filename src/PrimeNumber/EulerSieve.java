package PrimeNumber;
import java.util.ArrayList;
import java.util.List;

public class EulerSieve {
    public static void main(String[] args) {
        int n = 30; // 筛选质数的上限（假设n=30）
        List<Integer> primes = eulerSieve(n);
        System.out.println("质数列表: " + primes);
    }

    public static List<Integer> eulerSieve1(int n) {
        // 1. 初始化 isPrime 数组，大小为 n+1（索引 0 到 n）
        //    isPrime[i] = true 表示 i 是质数
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true; // 初始默认所有数都是质数
        }

        // 2. 存储质数的动态数组（初始为空）
        List<Integer> primes = new ArrayList<>();

        // 3. 欧拉筛核心逻辑
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i); // 将 i 加入质数列表
            }

            // 用当前已知的质数 primes[j] 去标记合数 i * primes[j]
            for (int j = 0; j < primes.size(); j++) {
                int multiple = i * primes.get(j);
                if (multiple > n) {
                    break; // 超过范围时退出
                }
                isPrime[multiple] = false; // 标记为非质数

                // 关键优化：如果 i 能被 primes[j] 整除，则停止标记
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }

        return primes;
    }

    //使用欧拉筛对数进行质数的筛选
    public static List<Integer> eulerSieve(int n){
        boolean[] isPrime=new boolean[n+1];//表示数组下标从0-n,包含了数字n
        List<Integer> prime=new ArrayList<>();
        for(int i=2;i<=n;i++){
            isPrime[i]=true;//先将初始的所有值设置为true
        }
        for(int i=2;i<=n;i++){
            if(isPrime[i]){//如果是质数就将值加入到最终的集合容器中
                prime.add(i);
            }
            for(int j=0;j<prime.size();j++){
                int cur=i*prime.get(j);//遍历数的合数
                if(cur>n){
                    break;
                }
                isPrime[cur]=false;
                if(i%prime.get(j)==0){
                    break;
                }
            }
        }
        return prime;
    }
}
