#include<iostream>
#include<vector>
#include<map>
#include<algorithm>
#include<numeric>
#include<cmath>
#include"printVector.cpp"
#include"printDictionary.cpp"

bool cmp(std::pair<int,int> &a, std::pair<int,int> &b)
{
	if(a.second == b.second) 
		return a.first < b.first;
	return a.second > b.second;
}

int main()
{
	int N;
	std::cin>>N;
	std::vector<int> nums;
	std::map<int, int> dic;
	for (int i = 0; i < N; i ++)
	{
		int num;
		std::cin>>num;
		nums.push_back(num);
		if (dic[num] == 0)
			dic[num] = 1;
		else
			dic[num] += 1;
	}
	sort(nums.begin(), nums.end());
	// printVector(nums);
	// printDictionary(dic);
	//산술평균
	int avg = round(std::accumulate(nums.begin(),nums.end(),0.0) / N);
	std::cout<<avg<<std::endl;
	//중앙값
	int middle_num = nums[N/2];
	std::cout<<middle_num<<std::endl;
	//최빈값 같을 시  2번째
	std::vector<std::pair<int,int>> tempdic(dic.begin(), dic.end());
	sort(tempdic.begin(),tempdic.end(),cmp);
	// for (auto p : tempdic)
    // 	std::cout << "key = "<<p.first << ' ' <<"value = "<<p.second << '\n';
	if (tempdic[0].second == tempdic[1].second)
		std::cout << tempdic[1].first<<std::endl;
	else
		std::cout << tempdic[0].first<<std::endl;
	//범위
	std::cout<<nums.back() - nums.front();
}