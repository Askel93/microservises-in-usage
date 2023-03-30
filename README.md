Request examples:

###
GET http://localhost:8080/v1/organization/mes-organization/license/034827237

###
PUT http://localhost:8080/v1/organization/MES-Corp/license
Content-Type: application/json

{
"licenseId" : "34838492",
"organizationId" : "MES-Corp",
"description" : "Software product",
"productName" : "Great company",
"licenseType" : "complite"
}

###
POST http://localhost:8080/v1/organization/MES-Corp/license
Content-Type: application/json
Accept-Language: es

{
"licenseId" : "34838492",
"organizationId" : "MES-Corp",
"description" : "Software product",
"productName" : "Great company",
"licenseType" : "complite"
}