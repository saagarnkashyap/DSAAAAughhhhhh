        class Solution {
        public:

            int ans=0;
            bool isprime[5000005]; 

            int countPrimes(int n) {
                //consider all elements are prime
                for(int i=0;i<n;i++){
                    isprime[i]=true;
                }
                isprime[0]=isprime[1]=false;

                for(int i=2;i<n;i++){
                    if(isprime[i]==true){
                        //if a number is prime, mark all its multiples as nonprime
                        for(int j=2*i;j<n;j+=i){
                            isprime[j]=false;
                        }
                    }
                }

                //counts the number of prime numbers after using sieve of eratosthenes
                for(int i=0;i<n;i++){
                    if(isprime[i]){
                        ans++;
                    }
                }

                return ans;
                }
            };
            
        