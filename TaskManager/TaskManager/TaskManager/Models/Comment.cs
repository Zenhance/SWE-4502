using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager.Models
{
    using System;

    namespace TaskManager.Models
    {
        public class Comment
        {
            public Guid Id { get; set; }
            public string Content { get; set; }
            public string Author { get; set; }
            public DateTime CreatedAt { get; set; }

            public Comment()
            {
                Id = Guid.NewGuid();
                CreatedAt = DateTime.UtcNow;
            }
        }
    }
}
