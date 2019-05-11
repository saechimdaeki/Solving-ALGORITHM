#include<cstdio>
#include<iostream>
#include<algorithm>
#include<map>

using namespace std;

typedef struct _node{
	struct _node* head;
	struct _node* tail;
	struct _node* next;
	
	int power;
	
	_node()
	{
		power = 0;
		head = this;
		next = nullptr;
		tail = this;
	}
}node;

//map<int, bool> live;
struct _node country[100001];

void join(int& c1, int& c2)
{
	country[c1].head->tail->next = country[c2].head;
	country[c1].head->tail = country[c2].tail;
	
	country[c2].head = country[c1].head;
	country[c1].head->power += country[c2].head->power;
}

//void ruin(int& c1){
//	node* ptr = country[c1].head;
//	
//}

int main(){
	freopen("input.txt", "r", stdin);
	
	int N, M;
	scanf("%d %d", &N, &M); 
	
	for(int i=1; i<=N; ++i)
	{
		//live[i] = true;
		scanf("%d\n", &country[i].power);
	}
	
	for(int i=0; i<M; ++i)
	{
		int command, c1, c2;
		scanf("%d %d %d\n", &command, &c1, &c2);
		
		if(command == 1)
		{
			join(c1, c2);
		}
		else
		{
			if(country[c1].head->power < country[c2].head->power)
			{
				country[c2].head->power -= country[c1].head->power; 
				join(c2, c1);
			}
			else if(country[c1].head->power > country[c2].head->power)
			{
				country[c1].head->power -= country[c2].head->power; 
				join(c1, c2);
			}
			else
			{
				country[c1].head->power = country[c2].head->power = 0;
			}
		}
	}
	
	//sort(country+1, country+N+1, [](node& obj1, node& obj2){ return obj1.head->power < obj2.head->power;});

	for(int i=1; i<N+1; ++i)
	{
		printf("%d\n", country[i].head->power);
	}
}
