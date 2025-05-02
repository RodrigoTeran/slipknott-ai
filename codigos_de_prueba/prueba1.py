def compute_average(numbers_list):
    sum_values = 0
    count = 0
    for value in numbers_list:
        sum_values = sum_values + value
        count += 1
    if count == 0:
        return 0.0
    average = sum_values / count
    return average

def get_highest_number(values):
    highest = values[0]
    for current in values:
        if current > highest:
            highest = current
    return highest

data = [5, 8, 2, 10, 3]
print(f"Average value: {compute_average(data)}")
print(f"Highest number: {get_highest_number(data)}")