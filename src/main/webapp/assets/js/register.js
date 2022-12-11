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
		var fd = new FormData();
		fd.append('username', register_form.username.value);
		fd.append('name', register_form.name.value);
		fd.append('password', register_form.password.value);
		fd.append('title', register_form.title.value);
		fd.append('bio', register_form.bio.value);
		fd.append('birthday', register_form.birthday.value);
		fd.append('website', register_form.website.value);
		fd.append('degree', register_form.degree.value);
		fd.append('freelance', register_form.freelance.value);
		fd.append('email', register_form.email.value);
		fd.append('phone', register_form.phone.value);
		fd.append('address', register_form.address.value);
		fd.append('facebook', register_form.facebook.value);
		fd.append('skype', register_form.skype.value);
		fd.append('instagram', register_form.instagram.value);
		fd.append('linkedin', register_form.linkedin.value);
		fd.append('description', register_form.description.value);
		fd.append('avatar', register_form.avatar.files[0]);
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
		fd.append('skills', JSON.stringify(skills));

		$.ajax({
			url: 'Register',
			type: 'POST',
			data: fd,
			async: false,
			contentType: false,
			processData: false,
			success: () => {
				alert("Save Complete");
				location.href = "Index";
			},
		}).fail(function() {
			alert("Something went wrong");
		});;

	});

	$("#update").on('click', function(e) {
		e.preventDefault();
		// var data = {
		// 	title: register_form.title.value,
		// 	name: register_form.name.value,
		// 	bio: register_form.bio.value,
		// 	birthday: register_form.birthday.value,
		// 	website: register_form.website.value,
		// 	degree: register_form.degree.value,
		// 	freelance: register_form.freelance.value,
		// 	email: register_form.email.value,
		// 	phone: register_form.phone.value,
		// 	address: register_form.address.value,
		// 	facebook: register_form.facebook.value,
		// 	skype: register_form.skype.value,
		// 	instagram: register_form.instagram.value,
		// 	linkedin: register_form.linkedin.value,
		// 	description: register_form.description.value
		// };
		// var fd = new FormData();
		// var skills = [];
		// if (register_form.nameskill) {
		// 	if (register_form.nameskill.length == undefined) {
		// 		if (register_form.nameskill.value == '' ||
		// 			register_form.percent.value == '') {
		// 			alert('Please fill all input');
		// 			return;
		// 		}
		// 		skills.push({
		// 			name: register_form.nameskill.value,
		// 			percent: register_form.percent.value
		// 		})
		// 	} else {
		// 		register_form.nameskill.forEach((element, index) => {
		// 			if (register_form.percent[index].value == '' ||
		// 				element.value == '') {
		// 				alert('Please fill all input');
		// 				return;
		// 			}
		// 			skills.push({
		// 				Name: element.value,
		// 				Percent: register_form.percent[index].value
		// 			})
		// 		});
		// 	}
		// }
		// data.skills = JSON.stringify(skills);



		var fd = new FormData();
		fd.append('name', register_form.name.value);
		fd.append('title', register_form.title.value);
		fd.append('bio', register_form.bio.value);
		fd.append('birthday', register_form.birthday.value);
		fd.append('website', register_form.website.value);
		fd.append('degree', register_form.degree.value);
		fd.append('freelance', register_form.freelance.value);
		fd.append('email', register_form.email.value);
		fd.append('phone', register_form.phone.value);
		fd.append('address', register_form.address.value);
		fd.append('facebook', register_form.facebook.value);
		fd.append('skype', register_form.skype.value);
		fd.append('instagram', register_form.instagram.value);
		fd.append('linkedin', register_form.linkedin.value);
		fd.append('description', register_form.description.value);
		fd.append('avatar', register_form.avatar.files[0]);
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
		fd.append('skills', JSON.stringify(skills));
		$.ajax({
			type: "POST",
			url: "Update",
			data: fd,
			async: false,
			contentType: false,
			processData: false,
			success: function() {
				alert("Save Complete");
				location.href = "Index";
			}
		})
			.fail(function() {
				alert("Something went wrong");
			});

	});

	$("#avatar").on('change', function() {
		readURL(this);
	});

	var readURL = function(input) {
		if (input.files && input.files[0]) {
			var extension = input.files[0].name.split('.').pop().toLowerCase();
			if (input.files[0].size > 10000000 || $.inArray(extension, ['png', 'jpeg', 'jpg']) == -1) {
				$("#files").val(null);
				$('.validate_avatar').html('Format file must be .jpeg .jpg .png and size <=10MB');
			} else {
				$('.validate_avatar').html('');
			}
		}
	}
});