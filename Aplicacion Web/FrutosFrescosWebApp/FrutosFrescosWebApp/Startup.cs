using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(FrutosFrescosWebApp.Startup))]
namespace FrutosFrescosWebApp
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
