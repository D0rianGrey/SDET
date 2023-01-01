import json

# Read
json_file = open('/Users/evhenyivakeryn/Downloads/clarity_final/SDET/src/main/resources/student.json', 'r')
json_data = json_file.read()

# Parse
obj = json.loads(json_data)
country = obj['country']
list_people = obj['people']

for i in range(len(list_people)):
    print(list_people[i].get("firstName"))
