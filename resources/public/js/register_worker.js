window.offlineRegisterWorker = function offlineRegisterWorker() {
  if(!('serviceWorker' in navigator)) {
    console.warn('Service worker is not available');
    return;
  }

  navigator.serviceWorker
    .register('/service-worker.js', { scope: '/' })
    .then(onRegistrationSuccess)
    .catch(function(error) {
      console.log('Registration failed with ' + error);
    });

  function onRegistrationSuccess(reg) {
    var installing;
    console.log('Registration succeeded. Scope is ' + reg.scope);
    reg.addEventListener('updatefound', onUpdateFound);

    function onUpdateFound() {
      installing = reg.installing;
      installing.addEventListener('statechange', onStateChange);
    }

    function onStateChange() {
      switch(installing.state) {
      case 'installed':
        {
          if(navigator.serviceWorker.controller) {
            alert('New version available !');
            self.location.reload(true);
          }
          else {
            alert('Application installed !');
          }
          break;
        }
      case 'redundant':
        {
          console.warn('ServiceWorker became redundant');
          break;
        }
      }
    }
  }
};
