function openEditPopup(id, title, text, datetime) {
	
	document.getElementById('edit-id').value = id;
	document.getElementById('edit-title').value = title;
	document.getElementById('edit-text').value = text;
	document.getElementById('edit-datetime').value = datetime;

	document.getElementById('edit-popup').style.display = 'block';
	document.getElementById('overlay').style.display = 'block';
}

function closeEditPopup() {
	document.getElementById('edit-popup').style.display = 'none';
	document.getElementById('overlay').style.display = 'none';
}