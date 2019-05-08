#include<cstdio>
#include<iostream>

using namespace std;
typedef long long ll;

ll N, M;
int budget[10000];

ll f(int bound){
	ll result=0;
	for(int i=0; i<N; ++i)
	{
		result+=(budget[i] - bound < 0? budget[i] : bound);
	}
	return result;
}

int main(){
	scanf("%d", &N);
	
	int max=0;
	for(int i=0; i<N; ++i){
		scanf("%d ", &budget[i]);
		if(max < budget[i]) max = budget[i];	
	}
	
	scanf("%d", &M);
	
	int left=0, right=max, ans;
	while(left<=right){
		
		int mid = (left+right)/2;
		ll fmid = f(mid);
		
		if(fmid <= M){
			ans = mid;
			left = mid + 1;
		}else right = mid - 1;
	}
	
	printf("%d", ans);
}
