// name: where we are
// if its value then , directly add name.key - value.
// if array {has key value pairs then recall the fun with this}
// if arrya (no key values then maintain counter and append values)

function process(user, object, directory) {
    if (!user || user.length == 0) {
        return;
    }
    const keys = Object.keys(user);
    for (let i = 0; i < keys.length; i++) {
        const keyName = directory + '_' + keys[i];
        if ('string' == typeof user[keys[i]]) {
            object[keyName] = user[keys[i]];
        }

        if ('object' == typeof user[keys[i]] && !Array.isArray(user[keys[i]])) {
            process(user[keys[i]], object, keyName);
        }

        if (Array.isArray(user[keys[i]])) {
            for(let i=0;i<user[keys[i]].length;i++){
                const arrayName = keyName + '_' + i;
                object[arrayName] = user[keys[i]][i];
            }
        }

    }
    return object;

}

const user = {
    name: "Abhishek",
    age: "25",
    address: {
        personal: {
            city: "Rohtak",
            pincode: "111111",
            area: "Near Chand Cinema",
            street: "Ashok Gali"
        },
        office: {
            city: "Noida",
            pincode: "201301"
        },
        school: "Maghad University"
    },
    hobbies: ["Coding", "Reading"],
    education: [
        { degree: "B.Tech", year: 2018 },
        { degree: "M.Tech", year: 2022 }
    ],
    isMarried: false,
    extraInfo: null
};

console.log(process(user, {}, 'user'));

/*
Input : 

const user = {
name: "Abhishek",
age: "25",
address: {
personal: {
city: "Rohtak",
pincode: "111111",
area: "Near Chand Cinema",
street: "Ashok Gali"
},
office: {
city: "Noida",
pincode: "201301"
},
school: "Maghad University"
},
hobbies: ["Coding", "Reading"],
education: [
{ degree: "B.Tech", year: 2018 },
{ degree: "M.Tech", year: 2022 }
],
isMarried: false,
extraInfo: null
};

output:

{

user_name: "Abhishek",

user_age: "25",

user_address_personal_city: "Rohtak",

user_address_personal_pincode: "111111",

user_address_personal_area: "Near Chand Cinema",

user_address_personal_street: "Ashok Gali",

user_address_office_city: "Noida",

user_address_office_pincode: "201301",

user_address_school: "Maghad University",

user_hobbies_0: "Coding",

user_hobbies_1: "Reading",

user_education_0_degree: "B.Tech",

user_education_0_year: 2018,

user_education_1_degree: "M.Tech",

user_education_1_year: 2022,

user_isMarried: false,

user_extraInfo: null

}
*/
