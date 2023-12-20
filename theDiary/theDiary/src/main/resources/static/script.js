function openEditPopup(id, title, text, datetime) {
	
	document.getElementById('editId').value = id;
	document.getElementById('editTitle').value = title;
	document.getElementById('editText').value = text;
	document.getElementById('editDatetime').value = datetime;

	document.getElementById('editPopup').style.display = 'block';
	document.getElementById('overlay').style.display = 'block';
}

function closeEditPopup() {
	document.getElementById('editPopup').style.display = 'none';
	document.getElementById('overlay').style.display = 'none';
}