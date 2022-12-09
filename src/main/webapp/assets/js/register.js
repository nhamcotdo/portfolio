$(function() {
	var skillindex = 0;
	$("#addskill").on('click', function(e) {
		e.preventDefault();
		$("#skill").append(`
                        <div class="wrap-input100 validate-input col-6">
                            <input id="skillname_skill${skillindex}" class="input100" type="text" name="nameskill" placeholder="Name skill"> <span class="focus-input100"></span>
                        </div>

                        <div class="wrap-input100 validate-input col-5">
                            <input id="skillpercent_skill${skillindex}" class="input100" type="number" min=0 max=100 name="percent" placeholder="Percent(%)"> <span class="focus-input100"></span>
                        </div>
                        <button _type="delskill" style="color: whitesmoke; font-size: 30px;" class="delSkill" id="skill${skillindex}">
							<i class="fa fa-times-circle " aria-hidden="true"></i>
						</button>
        `);
		skillindex++;
	});

	$("#skill").on('click', '.delSkill', function(e) {
		e.preventDefault();
		var id = $(this).attr('id');
		$(`#skillname_${id}`).parent().remove();
		$(`#skillpercent_${id}`).parent().remove();
		$(this).remove();
	});

	$("#register").on('click', function(e) {
		e.preventDefault();
		var data = {
			username: register_form.username.value,
			name: register_form.name.value,
			password: register_form.password.value,
			title: register_form.title.value,
			bio: register_form.bio.value,
			birthday: register_form.birthday.value,
			website: register_form.website.value,
			degree: register_form.degree.value,
			freelance: register_form.freelance.value,
			email: register_form.email.value,
			phone: register_form.phone.value,
			address: register_form.address.value,
			facebook: register_form.facebook.value,
			skype: register_form.skype.value,
			instagram: register_form.instagram.value,
			linkedin: register_form.linkedin.value,
			description: register_form.description.value
		};
		var skills = [];
		if (register_form.nameskill) {
			if (register_form.nameskill.length == undefined) {
				if (register_form.nameskill.value == '' ||
					register_form.percent.value == '') {
					alert('Please fill all input');
					return;
				}
				skills.push({
					name: register_form.nameskill.value,
					percent: register_form.percent.value
				})
			} else {
				register_form.nameskill.forEach((element, index) => {
					if (register_form.percent[index].value == '' ||
						element.value == '') {
						alert('Please fill all input');
						return;
					}
					skills.push({
						Name: element.value,
						Percent: register_form.percent[index].value
					})
				});
			}
		}
		data.skills = JSON.stringify(skills);
		$.ajax({
			type: "POST",
			url: "Register",
			data: data,
			dataType: "text",
			success: function() {
				alert("Save Complete");
				location.href = "Index";
			}
		})
			.fail(function() {
				alert("Something went wrong");
			});

	});

	$("#update").on('click', function(e) {
		e.preventDefault();
		var data = {
			title: register_form.title.value,
			name: register_form.name.value,
			bio: register_form.bio.value,
			birthday: register_form.birthday.value,
			website: register_form.website.value,
			degree: register_form.degree.value,
			freelance: register_form.freelance.value,
			email: register_form.email.value,
			phone: register_form.phone.value,
			address: register_form.address.value,
			facebook: register_form.facebook.value,
			skype: register_form.skype.value,
			instagram: register_form.instagram.value,
			linkedin: register_form.linkedin.value,
			description: register_form.description.value
		};
		var skills = [];
		if (register_form.nameskill) {
			if (register_form.nameskill.length == undefined) {
				if (register_form.nameskill.value == '' ||
					register_form.percent.value == '') {
					alert('Please fill all input');
					return;
				}
				skills.push({
					name: register_form.nameskill.value,
					percent: register_form.percent.value
				})
			} else {
				register_form.nameskill.forEach((element, index) => {
					if (register_form.percent[index].value == '' ||
						element.value == '') {
						alert('Please fill all input');
						return;
					}
					skills.push({
						Name: element.value,
						Percent: register_form.percent[index].value
					})
				});
			}
		}
		data.skills = JSON.stringify(skills);
		$.ajax({
			type: "POST",
			url: "Update",
			data: data,
			dataType: "text",
			success: function() {
				alert("Save Complete");
				location.href = "Index";
			}
		})
			.fail(function() {
				alert("Something went wrong");
			});

	});
});