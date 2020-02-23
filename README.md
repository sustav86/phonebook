# phonebook

MultipartFile example:
```
{
    "username": "Mike",
    "firstName": "Mikel",
    "lastName": "Tyson",
    "roles": [{"name" : "ROLE_RESGISTERED_USER"}],
    "phone": [{
            "countryCode": 5,
            "number": 66666,
            "phoneCompany": {
                "name": "Nike"
            }
        }, {
            "countryCode": 15,
            "number": 87654,
            "phoneCompany": {
                "name": "Adidas"
            }
        }
    ]
}
```