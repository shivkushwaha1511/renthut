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
    email : /^([a-z][a-z\d-_]*)@([a-z]{2,})\.([a-z]{2,5})(\.[a-z]{2,5})?$/,
    password : /^[A-Za-z\d@_-]{8,20}$/
};

const result = {
    email: false,
    password: false
};

const validate = function(pattern,field){
    let help = document.querySelector("#help_"+field.name);
    let err = document.querySelector("#err_"+field.name);

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

form.addEventListener("submit",function(event){
    if(result.email && result.password){
        return true;
    }else{
        event.preventDefault();
        return false;
    }
});