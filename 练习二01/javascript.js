const pet_data =
{
"pets": [
{
"name": "Scooby",
"breed": "Labrador"
},
{
"name": "Lassie",
"breed": "Collie"
},
{
"name": "Toto",
"breed": "Terrier"
},
{
"name": "Rin Tin Tin",
"breed": "German Shepherd"
}
]
};
const tableHeaders =
'<tr><th>name</th><th>breed</th></tr>';


let petsHTML = '';
petsHTML += tableHeaders;


const petRow =
'<tr><td>PET_NAME</td><td>PET_BREED</td></tr>';

function loadPetData() {
    pet_data.pets.forEach(pet => {
        let thisPetHTML = petRow;
        thisPetHTML = thisPetHTML.replace('PET_NAME', pet.name);
        thisPetHTML = thisPetHTML.replace('PET_BREED', pet.breed);
        petsHTML += thisPetHTML;

    });


    document.getElementById("pets").innerHTML = petsHTML ;
    //this line needs to be completed
}