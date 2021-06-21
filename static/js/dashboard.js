const title = document.querySelector("#id_title");
const description = document.querySelector("#id_description");
const city = document.querySelector("#id_city");
const address = document.querySelector("#id_address");
const propertyType = document.querySelector("#id_propertyType");
const electricityBill = document.querySelector("#id_electricityBill");
const bedroom = document.querySelector("#id_bedroom");
const bathroom = document.querySelector("#id_bathroom");
const room = document.querySelector("#id_room");
const area = document.querySelector("#id_area");
const distSchool = document.querySelector("#id_distSchool");
const distHospital = document.querySelector("#id_distHospital");
const floorType = document.querySelector("#id_floorType");
const waterTank = document.querySelector("#id_waterTank");
const parking = document.querySelector("#id_parking");
const terrace = document.querySelector("#id_terrace");
const ventilation = document.querySelector("#id_ventilation");
const garden = document.querySelector("#id_garden");
const pets = document.querySelector("#id_pets");

const nextBtn = document.querySelector("#id_nextBtn");

const gallery = document.querySelector("#gallery");
const details = document.querySelector("#details");
const prop_bar = document.querySelector("#prop_bar");
const gallery_pill = document.querySelector("#gallery_pill");

const addDetails = async ()=>{
	const response = await fetch("addpropertydetails.do",{
		method : "POST",
		
		body : JSON.stringify({
			title : title.value,
			description : description.value,
			city : city.value,
			address : address.value,
			property_type : propertyType.value,
			ele_bill : electricityBill.checked?0:1,
			bedroom : bedroom.value,
			bathroom : bathroom.value,
			room : room.value,
			area : area.value,
			dist_school : distSchool.value,
			dist_hospital : distHospital.value,
			floor_type : floorType.value,
			water_tank : waterTank.checked?1:0,
			parking : parking.checked?1:0,
			terrace : terrace.checked?1:0,
			ventilation : ventilation.checked?1:0,
			garden : garden.checked?1:0,
			pets : pets.checked?1:0
		}),
		
		headers: { 'Content-type': 'application/json; charset=UTF-8'}
	});
	
	//const data = await response.json();
	
	return response.text();
};

nextBtn.addEventListener("click",()=>{
	addDetails().then((data)=>{
		data = JSON.parse(data);
		
		if(data == "expired"){
			window.location = "signin.do";
		}else if(data == "failed"){
			console.log("failed");
		}else{
			details.classList.remove("show");
			details.classList.remove("active");
			gallery.classList.add("show");
			gallery.classList.add("active");
			gallery_pill.classList.add("active");
			prop_bar.style.display = "inline";
		}
	}).catch((error)=>{
		console.log("false");
	});
});










