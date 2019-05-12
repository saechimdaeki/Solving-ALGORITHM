#include<iostream>
#include<queue>
#include<algorithm>
#include<functional>
using namespace std;



bool visited[100001];
int n,m;
queue<pair <int , int> > q;

int bfs(int subin, int bro)
{
	q.push(make_pair(subin, 0 ));//subin이가 있는점 은  0초로 pair 하공  
	visited[subin]=true; //수빈이 현재 서잇는지점  visited니까  
	while(!q.empty())
	{
		int subin_location=q.front().first;
		int subin_time=q.front().second;
		q.pop();
		if(subin_location==bro)//동생에게 도착  
			return subin_time;
		//일차원 배열이지만 순간이동도 고려하니까 3가지방법
		if(subin_location*2<100001 && visited[subin_location*2]==false)
		{
			q.push(make_pair(subin_location*2,subin_time+1));
			visited[subin_location*2]=true;	
		}	//수빈이 순간이동할 경우
		
		//이아래부터는 그냥 일차원 배열일때 탐색  
		if(subin_location-1>=0 &&visited[subin_location-1]==false)
		{
			q.push(make_pair(subin_location-1,subin_time+1));
			visited[subin_location-1]=true;
		 } 
		 if(subin_location+1<100001 && visited[subin_location+1]==false)
		 {
		 	q.push(make_pair(subin_location+1,subin_time+1));
		 	visited[subin_location+1]=true;
		 }
		 
	}
}

int main()
{
	cin>>n>>m;
	cout<<bfs(n,m)<<endl;	
}
