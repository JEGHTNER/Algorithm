#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
	for (int i = 0; i< arr.size() - 1; i++){
		if (arr[i] != arr[i + 1])
			answer.push_back(arr[i]);
	}
	answer.push_back(arr[arr.size()-1]);
    return answer;
}

int main()
{
    int arr[] = { 4,4,4,3,3};
 
    std::vector<int> vec(std::begin(arr), std::end(arr));
 
	vec = solution(vec);
    for (int i: vec) {
        std::cout << i << ' ';
    }
 
    return 0;
}
