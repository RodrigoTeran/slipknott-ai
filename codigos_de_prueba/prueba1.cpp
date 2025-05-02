#include <iostream>
#include <vector>

using std::cout;
using std::endl;
using std::vector;

float computeAverage(const vector<int>& data) {
    if (data.size() == 0) return 0.0f;
    
    float total = 0.0f;
    for (auto val : data) {
        total = total + val;
    }
    return total / data.size();
}

int findMaxValue(const vector<int>& values) {
    if (values.empty()) return -999;
    
    int current_max = values[0];
    for (size_t j = 0; j < values.size(); j++) {
        if (values[j] > current_max) {
            current_max = values[j];
        }
    }
    return current_max;
}

int main() {
    vector<int> numbers = {12, 45, 23, 67, 8, 34};
    
    cout << "Average: " << computeAverage(numbers) << endl;
    cout << "Max value: " << findMaxValue(numbers) << endl;
    
    return EXIT_SUCCESS;
}