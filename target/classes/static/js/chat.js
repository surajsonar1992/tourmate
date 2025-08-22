(function(){
  const btn = document.getElementById('chat-toggle');
  const win = document.getElementById('chat-window');
  const closeBtn = document.getElementById('chat-close');
  const form = document.getElementById('chat-form');
  const input = document.getElementById('chat-input');
  const body = document.getElementById('chat-messages');

  if (!btn) return;

  function append(type, text){
    const div = document.createElement('div');
    div.className = `msg ${type}`;
    div.textContent = text;
    body.appendChild(div);
    body.scrollTop = body.scrollHeight;
  }

  btn.addEventListener('click', () => win.classList.toggle('d-none'));
  closeBtn.addEventListener('click', () => win.classList.add('d-none'));

  form.addEventListener('submit', async (e) => {
    e.preventDefault();
    const text = input.value.trim();
    if(!text) return;
    append('user', text);
    input.value='';
    try {
      const res = await fetch('/api/chat', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ message: text })
      });
      const data = await res.json();
      append('bot', data.reply || 'No response');
    } catch(err){
      append('bot', 'Error contacting server.');
    }
  });
})();
