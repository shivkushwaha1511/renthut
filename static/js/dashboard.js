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
const updtBtn = document.querySelector("#id_updtBtn");

const gallery = document.querySelector("#gallery");
const details = document.querySelector("#details");
const prop_bar = document.querySelector("#prop_bar");
const gallery_pill = document.querySelector("#gallery_pill");
const details_pill = document.querySelector("#details_pill");

const addDetails = async ()=>{
	const response = await fetch("addpropertydetails.do",{
		method : "POST",
		
		body : JSON.stringify({
			title : title.value,
			description : description.value,
			city : city.value,
			address : address.value,
			property_type : propertyType.value,
			ele_bill : electricityBill.checked?false:true,
			bedroom : bedroom.value,
			bathroom : bathroom.value,
			room : room.value,
			area : area.value,
			dist_school : distSchool.value,
			dist_hospital : distHospital.value,
			floor_type : floorType.value,
			water_tank : waterTank.checked?true:false,
			parking : parking.checked?true:false,
			terrace : terrace.checked?true:false,
			ventilation : ventilation.checked?true:false,
			garden : garden.checked?true:false,
			pets : pets.checked?true:false
		}),
		
		headers: { 'Content-type': 'application/json; charset=UTF-8'}
	});
	
	//const data = await response.json();
	
	return response.text();
};

updtBtn.addEventListener("click",()=>{
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
				prop_bar.style.display = "block";
		}
	}).catch((error)=>{
		console.log("false");
	});
});


updtBtn.addEventListener("click",()=>{
	details.classList.remove("show");
	details.classList.remove("active");
	gallery.classList.add("show");
	gallery.classList.add("active");
	details_pill.classList.remove("active");
	gallery_pill.classList.add("active");
});

/************************************************* */

const thumb_next = document.querySelector("#thumb_next");
const thumb_upload = document.querySelector("#thumb_upload");
const pic_next = document.querySelector("#pic_next");
const thumbnail_box = document.querySelector("#thumbnail_box");
const property_pics_box = document.querySelector("#property_pics_box");

thumb_next.addEventListener("click",()=>{
	thumbnail_box.style.display = "none";
	property_pics_box.style.display = "block";
});

thumb_upload.addEventListener("click",()=>{
	thumbnail_box.style.display = "none";
	property_pics_box.style.display = "block";
});

pic_next.addEventListener("click",()=>{
	thumbnail_box.style.display = "block";
	property_pics_box.style.display = "none";
});

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

const btn_props_edits = document.querySelectorAll(".btn_prop_edit");
const main_body = document.querySelector("#main-body");
const left_col = document.querySelector("#left-col");

btn_props_edits.forEach((btn_prop_edit)=>{
	btn_prop_edit.addEventListener("click",(event)=>{
		const edit_prop_box = document.querySelector("#edit_prop_box_"+event.target.id.substring(3));
		edit_prop_box.style.display = "block";
		main_body.style.position = "fixed";
		left_col.classList.remove("sticky-top");
	});
});

const btn_close = document.querySelectorAll(".btn-close");

btn_close.forEach((btn)=>{
	btn.addEventListener("click",(event)=>{
		let id = event.target.id.substring(4);
		const edit_prop_box = document.querySelector("#edit_prop_box_"+id);
		edit_prop_box.style.display = "none";
		main_body.style.position = "static";
		left_col.classList.add("sticky-top");
			
				
	});
});

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

const updtBtns = document.querySelectorAll(".updtBtn");

updtBtns.forEach((updtBtn)=>{
	updtBtn.addEventListener("click",(event)=>{
		let id = event.target.id.substring(11);
		const N_title = document.querySelector("#id_title_"+id);
		const N_description = document.querySelector("#id_description_"+id);
		const N_city = document.querySelector("#id_city_"+id);
		const N_address = document.querySelector("#id_address_"+id);
		const N_propertyType = document.querySelector("#id_propertyType_"+id);
		const N_electricityBill = document.querySelector("#id_electricityBill_"+id);
		const N_bedroom = document.querySelector("#id_bedroom_"+id);
		const N_bathroom = document.querySelector("#id_bathroom_"+id);
		const N_room = document.querySelector("#id_room_"+id);
		const N_area = document.querySelector("#id_area_"+id);
		const N_distSchool = document.querySelector("#id_distSchool_"+id);
		const N_distHospital = document.querySelector("#id_distHospital_"+id);
		const N_floorType = document.querySelector("#id_floorType_"+id);
		const N_waterTank = document.querySelector("#id_waterTank_"+id);
		const N_parking = document.querySelector("#id_parking_"+id);
		const N_terrace = document.querySelector("#id_terrace_"+id);
		const N_ventilation = document.querySelector("#id_ventilation_"+id);
		const N_garden = document.querySelector("#id_garden_"+id);
		const N_pets = document.querySelector("#id_pets_"+id);
		
		const updtDetails = async ()=>{
			const response = await fetch("addpropertydetails.do",{
				
				method : "POST",
			
				body : JSON.stringify({
					id : id,
					title : N_title.value,
					description : N_description.value,
					city : N_city.value,
					address : N_address.value,
					property_type : N_propertyType.value,
					ele_bill : N_electricityBill.checked?false:true,
					bedroom : N_bedroom.value,
					bathroom : N_bathroom.value,
					room : N_room.value,
					area : N_area.value,
					dist_school : N_distSchool.value,
					dist_hospital : N_distHospital.value,
					floor_type : N_floorType.value,
					water_tank : N_waterTank.checked?true:false,
					parking : N_parking.checked?true:false,
					terrace : N_terrace.checked?true:false,
					ventilation : N_ventilation.checked?true:false,
					garden : N_garden.checked?true:false,
					pets : N_pets.checked?true:false
				}),
				
				headers: { 'Content-type': 'application/json; charset=UTF-8'} 				
			});
			
			return response.text();
		};

		updtDetails().then((data)=>{
			data = JSON.parse(data);
	
			if(data == "expired"){
				window.location = "signin.do";
			}else if(data == "failed"){
				console.log("failed");
			}
		}).catch((error)=>{
			console.log("fail")
		})
	});
});

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

const view_records = document.querySelector("#view_records");
const prop_listing_box = document.querySelector("#prop_listing_box");
const prop_listing_text = document.querySelector("#prop_listing_text");
const prop_records_box = document.querySelector("#prop_records_box");
const record_back_btn = document.querySelector("#record_back_btn");

record_back_btn.addEventListener("click",()=>{
	prop_listing_box.style.display = "block";
	prop_listing_text.style.display = "block";
	prop_records_box.style.display = "none";
});

view_records.addEventListener("click",()=>{
	prop_listing_box.style.display = "none";
	prop_listing_text.style.display = "none";
	prop_records_box.style.display = "block";	
});




























