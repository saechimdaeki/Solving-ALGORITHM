#include<iostream>
using namespace std;
char arr[3072][6144]; 

void againstar(int n, int x, int y)
{
    if (n == 3)                                    // n이 3이면 별찍기
    {
        arr[y][x] = '*';
        
        arr[y + 1][x - 1] = '*';
        arr[y + 1][x + 1] = '*';
 
        arr[y + 2][x - 2] = '*';
        arr[y + 2][x - 1] = '*';
        arr[y + 2][x] = '*';
        arr[y + 2][x + 1] = '*';
        arr[y + 2][x + 2] = '*';
    }
    else                                        // n이 3이 아니면 재귀함수
    {
        againstar(n / 2, x, y);
        againstar(n / 2, x-n/2, y+n/2);
        againstar(n / 2, x-n/2+n, y+n/2);
    }
}


 
int main()
{
    int n;
    cin >> n;
 
    for (int i = 0; i < n; i++)                    
    {
        for (int j = 0; j < 2*n-1; j++)
        {
                arr[i][j] = ' ';
        }
    }
 
    againstar(n, n-1, 0);                            
 
    for (int i = 0; i < n; i++)                   
    {
        for (int j = 0; j < 2 * n -1; j++)
        {
            cout << arr[i][j];
        }
        cout <<endl;
    }
}
