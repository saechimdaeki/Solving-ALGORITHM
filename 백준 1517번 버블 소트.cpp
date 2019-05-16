#include <iostream>
using namespace std;
const int MAX = 500000;
int arr[MAX], arr2[MAX];
long long bubble(int start, int end)
{
        if (start == end)
                 return 0;
        int mid = (start + end) / 2;
        //반으로 분할하여 탐색
        long long result = bubble(start, mid) + bubble(mid + 1, end);
        int i = start;
        int j = mid + 1;
        int idx = 0;
        while (i <= mid || j <= end)
        {
                 //순서대로 잘 있다면 그냥 추가해주고
                 if (i <= mid && (j > end || arr[i] <= arr[j]))
                         arr2[idx++] = arr[i++];
                 else
                 {
                         result += (mid - i + 1) * 1LL;
                         arr2[idx++] = arr[j++];
                 }
        }
        for (int k = start; k <= end; k++)
                 arr[k] = arr2[k - start];
        return result;
}
int main(void)
{
        ios::sync_with_stdio(0);
        cin.tie(0);
        int N;
        cin >> N;
        for (int i = 0; i < N; i++)
                 cin >> arr[i];
        long long result = bubble(0, N - 1);
        cout << result << "\n";
        return 0;
}
