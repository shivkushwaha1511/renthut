//Unique email-----------------------------------------------
const email_field = document.querySelector("#email_field");


const ajaxReq = async ()=>{
    let response = await fetch(`uniqueemail.do?email=${email_field.value}`);
    return response.text();
};

const checkEmail = ()=>{
    ajaxReq().then((data)=>{
        if(result.email){
            if(data == "true"){
                const Ehelp = document.querySelector("#help_email");
                const Eerror = document.querySelector("#err_email");

                Ehelp.classList.replace("show","hide");
                Eerror.classList.replace("hide","show");
                Eerror.innerHTML = "User With Entered Email Already Exists";
                result.email = false;
                email_field.classList.replace("success","fail");
            }
        }
    });
};

email_field.addEventListener("blur",checkEmail);

//View Password---------------------------------------------
const eye = document.querySelector("#eye-view");

let flag = true;

eye.addEventListener("click",(event)=>{
	let pass = document.querySelector("#pass");
	if(flag){
		pass.type = "text";
		flag = false;
	}else{
		pass.type = "password";
		flag = true;
	}
});


//Field Validation------------------------------------------
const inputs = document.querySelectorAll("input");
const address = document.querySelector("#address");
const err_address = document.querySelector("#err_address");
const form = document.forms[0];

const Patterns = {
    name : /^[A-z a-z]{3,50}$/,
    email : /^([a-z][a-z\d-_]*)@([a-z]{2,})\.([a-z]{2,5})(\.[a-z]{2,5})?$/,
    password : /^[A-Za-z\d@_-]{8,20}$/
};

const result = {
    name : false,
    email: false,
    password: false,
    address: false
};

const validate = function(pattern,field){
    let help = document.querySelector("#help_"+field.name);
    let err = document.querySelector("#err_"+field.name);

    if(err.id == "err_email"){
        err.innerHTML = "Invalid Email";
    }

    if(pattern.test(field.value)){
        field.classList.replace("fail","success");
        result[field.name] = true;
        help.classList.replace("hide","show");
        err.classList.replace("show","hide");
    }
    else{
        if(field.classList.contains("success")){
                field.classList.replace("success","fail");
                help.classList.replace("show","hide");
                err.classList.replace("hide","show");
        }
        else{
            field.classList.add("fail");
            help.classList.add("hide");
            err.classList.replace("hide","show");
        }

        result[field.name] = false;
    }
};

inputs.forEach(function(input){
    input.addEventListener("keyup",function(event){
         let pattern = Patterns[event.target.name];
         let field = event.target;
         validate(pattern,field);
    });

    input.addEventListener("blur",function(event){
         let pattern = Patterns[event.target.name];
         let field = event.target;
         validate(pattern,field);
    });
});

address.addEventListener("keyup",function(event){
    if(address.value == ""){
        if(address.classList.contains("success")){
            address.classList.replace("success","fail");
            err_address.classList.replace("hide","show");
        }
        else{
            address.classList.add("fail");
            err_address.classList.replace("hide","show");
        }
    }else{
        address.classList.replace("fail","success");
        result.address = true;
        err_address.classList.replace("show","hide");
    }
});

address.addEventListener("blur",function(event){
    if(address.value == ""){
        if(address.classList.contains("success")){
            address.classList.replace("success","fail");
            err_address.classList.replace("hide","show");
        }
        else{
            address.classList.add("fail");
            err_address.classList.replace("hide","show");
        }
    }else{
        address.classList.replace("fail","success");
        result.address = true;
        err_address.classList.replace("show","hide");
    }
});


form.addEventListener("submit",function(event){
    if(result.name && result.email && result.password && result.address){
        return true;
    }else{
        event.preventDefault();
        return false;
    }
});